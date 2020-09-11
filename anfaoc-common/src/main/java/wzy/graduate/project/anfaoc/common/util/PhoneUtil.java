package wzy.graduate.project.anfaoc.common.util;

import wzy.graduate.project.anfaoc.common.model.Response;
import wzy.graduate.project.anfaoc.common.model.dto.PhoneCheckResponse;

import java.util.Objects;

public class PhoneUtil {

    public static PhoneCheckResponse checkPhoneNumber(String phoneNumber){
        PhoneCheckResponse response = new PhoneCheckResponse();
        response.setResult(true);
        if(Objects.isNull(phoneNumber) || phoneNumber.length() == 0){
            response.setMsg("请填写电话号码");
            response.setResult(false);
            return response;
        }


        return response;
    }
}
