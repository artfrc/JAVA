package com.training.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class ClientResponse {

        private String message;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        private LocalDate date;
        private Integer status;
        private Integer count;
        private List<Client> clientList;

        public ClientResponse(String message, Integer status, Integer count, List<Client> clientList) {
                this.message = message;
                this.date = LocalDate.now();
                this.status = status;
                this.count = count;
                this.clientList = clientList;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public LocalDate getDate() {
                return date;
        }

        public void setDate(LocalDate date) {
                this.date = date;
        }

        public Integer getStatus() {
                return status;
        }

        public void setStatus(Integer status) {
                this.status = status;
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

