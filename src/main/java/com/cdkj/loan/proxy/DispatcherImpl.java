package com.cdkj.loan.proxy;

import com.cdkj.loan.api.IProcessor;
import com.cdkj.loan.common.JsonUtil;
import com.cdkj.loan.exception.BizException;
import com.cdkj.loan.exception.ParaException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DispatcherImpl implements IDispatcher {

    @Override
    public String doDispatcher(String transcode, String inputParams,
            String operator) {
        String result = null;
        // 加载配置文件,proxy实例化
        String classname = "com.cdkj.loan.api.impl.XNOther";
        ReturnMessage rm = new ReturnMessage();
        try {
            // ConfigDescribe configDescribe = ConfigLoader.loadConfig();
            /*
             * if (StringUtils.isNotBlank(transcode) && configDescribe != null)
             * { List<String> codeList = configDescribe.getCodeList(); if
             * (codeList.contains(transcode)) { classname =
             * "com.cdkj.coin.api.impl.XN" + transcode; } }
             */
            classname = "com.cdkj.loan.api.impl.XN" + transcode;
            IProcessor processor = (IProcessor) ReflectUtil
                    .getInstance(classname);
            // 接口调用
            Object data = processor.doProcessor(inputParams, operator);
            rm.setErrorCode(EErrorCode.SUCCESS.getCode());
            rm.setErrorInfo(EErrorCode.SUCCESS.getValue());
            if (data == null) {
                data = new Object();
            }
            rm.setData(data);
        } catch (Exception e) {
            if (e instanceof BizException) {
                rm.setErrorCode(EErrorCode.BIZ_ERR.getCode());
                rm.setErrorInfo(((BizException) e).getErrorMessage());
                rm.setData(e.getMessage());

            } else if (e instanceof ParaException) {
                rm.setErrorCode(EErrorCode.PARA_ERR.getCode());
                rm.setErrorInfo(((ParaException) e).getErrorMessage());
                rm.setData(e.getMessage());
            } else if (e instanceof NullPointerException) {
                rm.setErrorCode(EErrorCode.OTHER_ERR.getCode());
                rm.setErrorInfo(((NullPointerException) e).getMessage());
                rm.setData(e.getMessage());
            } else {
                rm.setErrorCode(EErrorCode.OTHER_ERR.getCode());
                rm.setErrorInfo(e.getMessage());
                // rm.setErrorInfo("系统错误，请联系客服");
                rm.setData(e.getMessage());
            }

            log.error("错误异常:{}", e.getMessage());
        } finally {
            result = JsonUtil.Object2Json(rm);
        }
        return result;
    }
}
