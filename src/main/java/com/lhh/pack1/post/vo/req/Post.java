package com.lhh.pack1.post.vo.req;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    private Long postId;
    private Long createUserId;// '创建人',
    private Integer type;// '状态：0已提交，1审核中，2审核通过，3审核失败',
    private String title;// '贴吧头',
    private String content;// '贴吧内容',
    private String goodsUrl;//'商品路径',
    private String goodsId;// '商品id',
    private String img;// '贴吧图片',
    private Date createTime;// '创建时间',
    private Integer praiseCount;// '被赞次数',
    private Integer replyCount;// '回复数',
    private Integer deleted;// ''通用状态: 1:正常, 2:已删除
    private Long boardId;//板块id
    private int pageCou;//浏览量
    private Integer rotate;//置顶1:没有置顶，2：置顶
    private int status;//区分帖子和文章，0：帖子，1：文章'
    private String boardName;//板块名
    private String startTime;//搜索开始时间
    private String endTime;//搜索结束时间
    private String userImg;
    private String userName;
    private Integer elite;//0:普通，1：精贴'
    private Integer userType;//用户类型0：普通会员，1管理员
    private Integer commentMebCou;
    private Integer collectionCount;//收藏数量
    private Integer isCollection;//是否收藏
    private Integer isFollow;//是否关注
    private  Long current;
    private Integer isCrown;
    public String getUserImg() {
        return userImg;
    }
    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getRotate() {
        return rotate;
    }
    public void setRotate(Integer rotate) {
        this.rotate = rotate;
    }
    public Long getPostId() {
        return postId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }
    public Long getCreateUserId() {
        return createUserId;
    }
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getGoodsUrl() {
        return goodsUrl;
    }
    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }
    public String getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getPraiseCount() {
        return praiseCount;
    }
    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }
    public Integer getReplyCount() {
        return replyCount;
    }
    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getDeleted() {
        return deleted;
    }
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    public Long getBoardId() {
        return boardId;
    }
    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }
    public int getPageCou() {
        return pageCou;
    }
    public void setPageCou(int pageCou) {
        this.pageCou = pageCou;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getBoardName() {
        return boardName;
    }
    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public Integer getElite() {
        return elite;
    }
    public void setElite(Integer elite) {
        this.elite = elite;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getCommentMebCou() {
        return commentMebCou;
    }

    public void setCommentMebCou(Integer commentMebCou) {
        this.commentMebCou = commentMebCou;
    }

    public Integer getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(Integer collectionCount) {
        this.collectionCount = collectionCount;
    }

    public Integer getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(Integer isCollection) {
        this.isCollection = isCollection;
    }

    public Integer getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(Integer isFollow) {
        this.isFollow = isFollow;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Integer getIsCrown() {
        return isCrown;
    }

    public void setIsCrown(Integer isCrown) {
        this.isCrown = isCrown;
    }
}
