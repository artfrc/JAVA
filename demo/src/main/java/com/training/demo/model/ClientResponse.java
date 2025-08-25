package com.training.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class ClientResponse {

        private String message;
        private Integer count;
        private List<Client> clientList;

        public ClientResponse(String message, Integer count, List<Client> clientList) {
                this.message = message;
                this.count = count;
                this.clientList = clientList;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public Integer getCount() {
                return count;
        }

        public void setCount(Integer count) {
                this.count = count;
        }

        public List<Client> getClientList() {
                return clientList;
        }

        public void setClientList(List<Client> clientList) {
                this.clientList = clientList;
        }
}

