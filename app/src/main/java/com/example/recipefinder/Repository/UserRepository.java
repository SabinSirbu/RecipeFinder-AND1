package com.example.recipefinder.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.recipefinder.Database.UserDao;
import com.example.recipefinder.Database.UserDatabase;
import com.example.recipefinder.Model.User;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private static UserRepository instance;
    private LiveData<List<User>> allUsers;

    private UserRepository(Application application){
        UserDatabase database = UserDatabase.getInstance(application);
        userDao = database.userDao();
        allUsers = userDao.getAllUsers();
    }

    public static UserRepository getInstance(Application application){
        if(instance == null){
            instance = new UserRepository(application);
        }
        return instance;
    }

    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

    public void insert(User user){
        new UserRepository.InsertUserAsync(userDao).execute(user);
    }

    public void update(User user){
        userDao.update(user);
    }

    public void deleteAllUsers(){
        userDao.deleteAllRecipes();
    }

    private static class InsertUserAsync extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        private InsertUserAsync(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

}
