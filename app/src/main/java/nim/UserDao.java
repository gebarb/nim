package nim;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;



@Dao
public interface UserDao
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addUser(UserData username);

    @Update
    public void addGame(UserData username);

    @Query("SELECT * FROM UserData WHERE username LIKE :name")
    public UserData getUser(String name);

    @Query("SELECT * FROM UserData")
    public UserData[] getAllUsers();

}
