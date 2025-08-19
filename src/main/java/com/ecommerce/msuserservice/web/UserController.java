package com.ecommerce.msuserservice.web;

import com.ecommerce.msuserservice.dto.UserRequest;
import com.ecommerce.msuserservice.dto.UserResponse;
import com.ecommerce.msuserservice.service.UserAppService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController @RequestMapping("/api/v1/users")
public class UserController {
    private final UserAppService app;
    public UserController(UserAppService app) { this.app = app; }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest req) {
        var res = app.create(req);
        return ResponseEntity.created(URI.create("/api/v1/users/" + res.id())).body(res);
    }
    @GetMapping("/{id}") public UserResponse get(@PathVariable Long id) { return app.get(id); }
    @GetMapping public java.util.List<UserResponse> list() { return app.list(); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        app.delete(id); return ResponseEntity.noContent().build();
    }
}