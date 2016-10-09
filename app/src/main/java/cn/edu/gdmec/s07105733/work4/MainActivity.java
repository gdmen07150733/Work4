package cn.edu.gdmec.s07105733.work4;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends Activity {
private TextView tView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         tView=new TextView(this);
        tView.setText("请单击按键或屏幕");
        setContentView(tView);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_HOME:
                SetMessage("按下：HOME键");
                break;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("按下：菜单键");
                return true;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("按下：返回键");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("按下：声音增加键");
                event.startTracking();
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("按下:声音减少键");
                event.startTracking();
                return true;
            default:
                SetMessage("按下的键码是"+keyCode);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_HOME:
                SetMessage("放开：HOME键");
                break;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("放开：菜单键");
                return true;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("放开：返回键");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("放开：声音增加键");
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("放开:声音减少键");
                return true;
            default:
                SetMessage("放开的键码是"+keyCode);
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        SetMessage("长时间按键");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        if (action==MotionEvent.ACTION_CANCEL||action==MotionEvent.ACTION_DOWN||action==MotionEvent.ACTION_MOVE){
            return false;
        }
        String x=String.valueOf(event.getX());
        String y=String.valueOf(event.getY());
        SetMessage("触点坐标:("+x+","+y+")");
        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SetMessage("按下返回键了");
    }
    public void SetMessage(String str){
        String oldStr=tView.getText().toString();
        String newStr=oldStr+"\n"+str;
        tView.setText(newStr);
    }
}
