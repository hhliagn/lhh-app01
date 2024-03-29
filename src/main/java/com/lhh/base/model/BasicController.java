package com.lhh.base.model;

import com.lhh.base.aware.SessionUser;
import com.lhh.base.enums.http.Enum401Error;
import com.lhh.base.exception.APIException;
import com.lhh.base.exception.SessionUserNotFoundException;
import com.lhh.base.kit.HttpRenderKit;
import com.lhh.base.kit.LoggerKit;
import jodd.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicController {
    private static final String STRICT_EVN_KEY = "STRICT";
    private static final String STRICT_EVN_VALUE = "KUAICTO";
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String httpBody;

    public BasicController() {
    }

    protected SessionUser getSessionUserFromGateway() throws APIException {
        return this.getSessionUserFromGateway(this.request);
    }

    protected SessionUser getSessionUserFromGateway(SessionUser defaultSessionUser) throws APIException {
        return this.getSessionUserFromGateway(this.request, defaultSessionUser);
    }

    protected SessionUser getSessionUserFromGateway(HttpServletRequest request) throws APIException {
        SessionUser defaultSessionUser = new SessionUser();
        defaultSessionUser.setUserName("tester");
        defaultSessionUser.setUserId(-99L);
        return this.getSessionUserFromGateway(request, defaultSessionUser);
    }

    protected SessionUser getSessionUserFromGateway(HttpServletRequest request, SessionUser defaultSessionUser) throws APIException {
        SessionUser sessionUserFromGateway = null;

        try {
            sessionUserFromGateway = SessionUserResolver.getSessionUserFromGateway(request);
        } catch (SessionUserNotFoundException var7) {
            String strictEvnValue = System.getenv("STRICT");
            boolean isStrictMode = StringUtil.isNotEmpty(strictEvnValue) && "KUAICTO".equalsIgnoreCase(strictEvnValue);
            if (isStrictMode) {
                throw new APIException(Enum401Error.SGW_SESSION_USER_NOT_FOUND);
            }

            sessionUserFromGateway = defaultSessionUser;
        }

        sessionUserFromGateway.setOperationId(LoggerKit.getRID());
        return sessionUserFromGateway;
    }

    public HttpServletRequest getRequest() {
        return this.request;
    }

    public BasicController setRequest(HttpServletRequest request) {
        this.request = request;
        return this;
    }

    public HttpServletResponse getResponse() {
        return this.response;
    }

    public BasicController setResponse(HttpServletResponse response) {
        this.response = response;
        return this;
    }

    public BasicController setHttpBody(String httpBody) {
        this.httpBody = httpBody;
        return this;
    }

    public synchronized String getHttpBody() {
        if (StringUtil.isEmpty(this.httpBody)) {
            this.httpBody = HttpRenderKit.readData(this.getRequest()).trim();
        }

        return this.httpBody;
    }
}
