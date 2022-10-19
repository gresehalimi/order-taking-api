package com.melita.ordertakingapi.order;

import com.melita.ordertakingapi.error.InvalidData;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.util.regex.Pattern;

@Slf4j
public class OrderQueryValidator {

    private static final Pattern emailPattern= Pattern.compile("[!#$%&'*+-/=?^_`{|}~a-z0-9]+@[a-z0-9-\\\\.]+");
    private static final Pattern phonePattern= Pattern.compile("^\\+?[1-9][0-9]{1,2}0?[0-9]{6,9}$");

    static OrderCreateQuery validateCreateQuery(@NotNull OrderCreateQuery query){
       if(query.getCustomer() != null){
           query = query.withCustomer(validateCreateCustomerQuery(query.getCustomer()));
       }
       return query;
    }
    static OrderCreateQuery.OrderCustomer validateCreateCustomerQuery(OrderCreateQuery.OrderCustomer customer){
        if(!emailIsValid(customer.getEmail())){
            log.warn("email {} is not valid", customer.getEmail());
            throw new InvalidData(customer.getEmail());
        }
        if(!phoneIsValid(customer.getPhone())){
            log.warn("phone {} is not valid!", customer.getPhone());
            throw new InvalidData(customer.getPhone());
        }
      return customer;
    }

   static boolean emailIsValid (String email){
      return email !=null && emailPattern.matcher(email.trim().toLowerCase()).matches();
    }

    static boolean phoneIsValid(String phone){
        return phone !=null && phonePattern.matcher(phone.trim().replaceAll("[ -]+]","")).matches();
    }
}
