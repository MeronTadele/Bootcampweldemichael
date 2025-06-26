package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.ProfileDao;
import org.yearup.data.UserDao;
import org.yearup.models.Profile;
import org.yearup.models.User;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/profile")
@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class ProfileController {
    private ProfileDao profileDao;
    private UserDao userDao;

    @Autowired
    public ProfileController(ProfileDao profileDao, UserDao userDao) {
        this.profileDao = profileDao;
        this.userDao = userDao;
    }

    @GetMapping()
    public Profile getByUserId(Principal principal) {
        try {

            if (principal == null) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }
            String username = principal.getName();
            User user = userDao.getByUserName(username);
            if (user == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
            int user_id = user.getId();
            var profile = profileDao.getByUserId(user_id);
            if (profile == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            return profile;
        } catch (Exception ex) {

            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ooops...our bad.");
        }
    }


    @PostMapping
    public ResponseEntity<Profile> create(@RequestBody Profile profile, Principal principal) {
        try {
            String username = principal.getName();
            User user = userDao.getByUserName(username);
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            profile.setUserId(user.getId());
            Profile createdProfile = profileDao.create(profile);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProfile);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody Profile profile, Principal principal) {
        try {
            if (principal == null) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }
            String username = principal.getName();
            User user = userDao.getByUserName(username);
            if (user == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
            int userid = user.getId();
            boolean updated = profileDao.update(userid, profile.getFirstName(), profile.getLastName(), profile.getPhone(), profile.getEmail(), profile.getAddress(), profile.getCity(), profile.getState(), profile.getZip());

        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}

