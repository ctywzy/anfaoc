package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import wzy.graduate.project.anfaoc.api.domain.entity.UserDetail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class jacksonTest {

    @Test
    public void serTest() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        UserDetail userDetail = new UserDetail();
        userDetail.setId(1L);
        userDetail.setPhoneNumber(123L);
        userDetail.setUserAge(7);

        List<UserDetail> list = new ArrayList<>();
        List<UserDetail> list1 = new ArrayList<>();
        list.add(userDetail);
        list.add(userDetail);
        System.out.println(userDetail.getClass());
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
        list1 = mapper.readValue(json,ArrayList.class);
        System.out.println(list1);
        if(userDetail instanceof UserDetail){
            System.out.println("===>true");
        }
        System.out.println(list1.get(0));
    }
}
