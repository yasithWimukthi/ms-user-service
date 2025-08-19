package com.ecommerce.msuserservice.service;

import com.ecommerce.msuserservice.domain.User;
import com.ecommerce.msuserservice.dto.UserRequest;
import com.ecommerce.msuserservice.dto.UserResponse;
import com.ecommerce.msuserservice.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserAppService {
    private final UserRepository repo;
    public UserAppService(UserRepository repo) { this.repo = repo; }

    public UserResponse create(UserRequest req) {
        if (repo.existsByEmail(req.email())) throw new IllegalArgumentException("Email already taken");
        var entity = User.builder()
                .firstName(req.firstName()).lastName(req.lastName()).email(req.email()).build();
        var saved = repo.save(entity);
        return toDto(saved);
    }

    @Transactional(readOnly = true)
    public UserResponse get(Long id) {
        return repo.findById(id).map(this::toDto)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Transactional(readOnly = true)
    public java.util.List<UserResponse> list() {
        return repo.findAll().stream().map(this::toDto).toList();
    }

    public void delete(Long id) { repo.deleteById(id); }

    private UserResponse toDto(User u) {
        return new UserResponse(u.getId(), u.getFirstName(), u.getLastName(), u.getEmail());
    }
}