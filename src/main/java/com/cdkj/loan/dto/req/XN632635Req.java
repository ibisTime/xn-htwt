package com.cdkj.loan.dto.req;

import lombok.Data;

/**
 * 分页查询违章
 *
 * @author: silver
 * @since: 2018年6月6日 下午5:04:26
 * @history:
 */
@Data
public class XN632635Req extends APageReq {

    /**
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
     */
    private static final long serialVersionUID = 5933298866541905618L;

    private String userId;

    private String status;

}
