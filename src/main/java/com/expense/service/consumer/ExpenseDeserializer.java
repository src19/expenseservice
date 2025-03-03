package com.expense.service.consumer;

import com.expense.service.dto.ExpenseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class ExpenseDeserializer implements Deserializer<ExpenseDto> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public void close() {};

    @Override
    public ExpenseDto deserialize(String arg0, byte[] arg1){
        ObjectMapper objectMapper = new ObjectMapper();
        ExpenseDto expenseDto = null;
        try{
            expenseDto = objectMapper.readValue(arg1, ExpenseDto.class);
        }catch(Exception e){
            e.printStackTrace();
        }
        return expenseDto;
    }


}
