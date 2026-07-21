package com.learning.services;

import com.learning.client.ApiClient;
import com.learning.constants.EndPoints;
import com.learning.models.AuthRequest;
import com.learning.models.AuthResponse;
import com.learning.config.ConfigManager;

public class AuthService {

    private ApiClient client = new ApiClient();

    public String generateToken() {

        AuthRequest request =
                new AuthRequest(
                        ConfigManager.get("username"),
                        ConfigManager.get("password"));

        return client.post(
                        EndPoints.AUTH,
                        request)
                .as(AuthResponse.class)
                .getToken();

    }

}