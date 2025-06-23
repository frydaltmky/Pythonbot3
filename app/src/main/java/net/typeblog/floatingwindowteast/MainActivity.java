package net.typeblog.floatingwindowteast;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.util.Log;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.util.Log;
import android.content.Context;
import android.widget.Toast;
import com.itsaky.androidide.logsender.LogSender;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Map;
import android.content.Intent;
import android.net.Uri;

import android.widget.Button;
//import android.view.View;
import android.widget.CompoundButton;
//import android.view.*;
import android.widget.Switch;

import android.widget.TextView;

import com.chaquo.python.PyException;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;



import android.provider.Settings;

import net.typeblog.floatingwindowteast.databinding.ActivityMainBinding;

import com.itsaky.androidide.logsender.LogSender;

public class MainActivity extends AppCompatActivity {
    
    
    
   private Button youtube;
    
   private TextView telegram;
    
   private Switch mySwitch;
    
    
    public void service  (){
        
        
        
        
            
       
        
        
               Python py = Python.getInstance();
               PyObject pyobj = py.getModule("teast");

// استدعاء الدالة وحفظ قيمة الـ return في متغير
              PyObject sum = pyobj.callAttr("server");
              String result = sum.toString();  
        
      //  Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
        
        
        
        
        
      
        
       // String r = "some st"; // تعريف المتغير r كنص

      if (result.contains("3757275727561947") || result.contains("374727573756")) {
            
            
           //  chek = true ;
            
                 //       startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION));
 
     
              
            
             
            
            
            
            
            
            
        
           Intent intent = new Intent(Intent.ACTION_MAIN);
                 intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 startActivity(intent);
            
            
                  startService(new Intent(MainActivity.this, FloatingWindowService.class));   
            
        //    onBackPressed();  
         
       } else {
           
            
          openYouTubeChannel();  
            
            
        //   Toast.makeText(getApplicationContext(),"codeooo!",Toast.LENGTH_LONG).show();
            
            
                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
            
               System.exit(0);
     // إعادة النص r في حالة إذا لم يتم تشغيل الخادم
}

        

        
        
        
        
    }

	    public void openYouTubeChannel() {
        String url = "https://www.youtube.com/@topfire383"; // Replace INSERT_CHANNEL_ID_HERE with your YouTube channel ID
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    
    
    
    
    public void opentelegrame() {
        String url = "https://t.me/topfire2v"; // Replace INSERT_CHANNEL_ID_HERE with your YouTube channel ID
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    
    
    
	
   @Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.activity_main);
        
        
        
                      
            
                   if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    if (!Settings.canDrawOverlays(this)) {
        // صلاحية "العرض فوق التطبيقات" غير ممكنة حاليًا، تطلب من المستخدم تفعيلها
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:" + getPackageName()));
        startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION));
                
                System.exit(0);
    }
  
   }     
        
        
        		youtube = (Button) findViewById(R.id.youtube);
	        	telegram = (Button) findViewById(R.id.telegram);
        
           
                 
       Switch mySwitch = findViewById(R.id.mySwitch);
        
        mySwitch.setChecked(false); 
        
    mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
                        
                        
               
                        service();
              
          //Intent intent = new Intent(this, FloatingWindowService.class);
       //    startService(intent);

                        
                        
                        
          //   Toast.makeText(getApplicationContext(),"Server ON",Toast.LENGTH_LONG).show();          
                        
                        
            // يتم تشغيل Switch
        } else {
                        
                        
                    stopService(new Intent(MainActivity.this, FloatingWindowService.class));   
                        
              Toast.makeText(getApplicationContext(),"Server OFF",Toast.LENGTH_LONG).show();  
                        
            // يتم إيقاف Switch
        }
    }
});

        
        
        
        
                
         Button youtuod = findViewById(R.id.youtube);
         youtuod.setOnClickListener(new View.OnClickListener() {
         @Override
             public void onClick(View v) {
                    
                    
                openYouTubeChannel();   
                    
          }
      });
        
        
        
        
        
        
         Button telegem = findViewById(R.id.telegram);
         telegem.setOnClickListener(new View.OnClickListener() {
         @Override
             public void onClick(View v) {
                    
                    
                   opentelegrame();
                    
          }
      });        
        
        
        
      
        
    }
    
}
