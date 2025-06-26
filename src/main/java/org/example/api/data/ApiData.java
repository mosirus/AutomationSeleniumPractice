package org.example.api.data;

import io.restassured.response.Response;

public class ApiData {

    private Integer page;
    private Response listUser;
    private Response postUser;
    private String apiKey;
    private String name;
    private String job;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Response getListUser() {
        return listUser;
    }

    public void setListUser(Response listUser) {
        this.listUser = listUser;
    }

    public Response getPostUser() {
        return postUser;
    }

    public void setPostUser(Response postUser) {
        this.postUser = postUser;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
