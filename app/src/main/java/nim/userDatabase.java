package nim;


import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {UserData.class}, version = 1, exportSchema = false)
public abstract class userDatabase extends RoomDatabase
{

   public abstract UserDao userDao();
}
