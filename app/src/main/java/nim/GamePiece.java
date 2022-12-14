package nim;

import android.content.Context;
import android.util.AttributeSet;

//@TargetApi(11)
public class GamePiece extends androidx.appcompat.widget.AppCompatButton {

    int color; //0=unselected, 1=selected, 2=removed
    int numRow = 8;

    public GamePiece(Context context)
    {
        super(context);

    }
    public GamePiece(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    public GamePiece(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public void chngColor(int c)
    {
        color = c;
        if(color == 0)
            this.setBackgroundResource(R.drawable.circle);
        else if(color == 1)
            this.setBackgroundResource(R.drawable.pressed);
        else
            this.setBackgroundResource(R.drawable.removed);
    }

    public int getColor()
    {
        return color;
    }

    public int getRow()
    {
        return numRow;
    }

    public void setRow(int r)
    {
        numRow = r;
    }

}
