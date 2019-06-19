package cast.code.android.com.newsapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

import cast.code.android.com.newsapp.NewsApplication;

public class Utils {


    public static void showToast(Context context, String message) {
        Toast.makeText( context, message, Toast.LENGTH_SHORT ).show();
    }

    /**
     * Method to detect network connection on the device
     */
    public static boolean isNetworkAvailable() {

        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) NewsApplication.getMyTimesApplicationInstance()
                    .getSystemService( Context.CONNECTIVITY_SERVICE );
            return (connectivityManager.getActiveNetworkInfo() != null)
                    && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();

        } catch (Exception e) {
            e.printStackTrace();


            return true;
        }

    }


}
