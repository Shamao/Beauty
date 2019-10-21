package com.louise.gank.bean.utils;

import com.louise.gank.bean.MContact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhishui <a href="mailto:liusd@tuya.com">Contact me.</a>
 * @since 2019-10-16
 */
public class BeanUtils {

    public static MContact buildContact(String name, String... phones) {
        MContact contact = new MContact();
        if (phones != null) {
            List<String> list = new ArrayList<>(Arrays.asList(phones));
            contact.setPhones(list);
        }
        contact.setName(name);
        return contact;
    }
}
