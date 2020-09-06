package com.honaf.mvvm.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.honaf.mvvm.MyApplication;
import com.honaf.mvvm.db.UserDao;
import com.honaf.mvvm.db.UserDatabase;
import com.honaf.mvvm.model.User;
import com.honaf.mvvm.repository.UserRepository;

public class UserViewModel extends AndroidViewModel {

    private LiveData<User> userLiveData;
    private UserRepository userRepository;
    private String userName = "honaf";

    public UserViewModel(MyApplication application){
        super(application);
        UserDatabase database =MyApplication.Companion.getUserDatabase();
        UserDao userDao = database.userDao();
        userRepository = new UserRepository(userDao,MyApplication.Companion.getApi());
        userLiveData = userRepository.getUser(userName);
    }

    public LiveData<User> getUserLiveData() {
        return userLiveData;
    }

    public void refresh(){
        userRepository.refresh(userName);
    }
}
