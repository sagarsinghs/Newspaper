package sangamsagar.newspapertime.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDataAccessObject {


    @Insert
    public  void addUser(User users);

    @Query("select * from Users")
    public List<User> getUsers();

    @Delete
    public  void deleteUser(User id);
}
