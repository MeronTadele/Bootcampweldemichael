package org.yearup.data;


import org.yearup.models.Profile;

public interface ProfileDao {
    Profile create(Profile profile);
    Profile getByUserId (int user_id);
    boolean update(int user_id,  String firstname, String lastName, String phone,
                String email,String address, String city, String state, String zip);
}
