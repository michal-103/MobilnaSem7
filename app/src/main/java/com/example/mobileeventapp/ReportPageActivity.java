package com.example.mobileeventapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReportPageActivity extends AppCompatActivity implements LocationListener {

    public static final int IMAGE_GALLERY_REQUEST = 20;
    public static final int CAMERA_REQUEST = 10;
    TextView latitude;
    TextView longitude;
    TextView provider;

    LocationManager locationManager;
    Criteria criteria;
    Location location;
    String bestProvider;
    private ImageView imgReport;
    private AutoCompleteTextView textDescription;


    private String nameOfEvent;
    private TextView eventName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page);
        refreshLocation();

        // get the reference to the image view that holds the image that the user will see
        nameOfEvent = getIntent().getStringExtra("type");
        imgReport = (ImageView) findViewById(R.id.imgReport);

        //get description about event
        textDescription = (AutoCompleteTextView) findViewById(R.id.textDescription);

        //put name of Event accident
        eventName = findViewById(R.id.eventName);
        eventName.setText(nameOfEvent);
    }

    private void refreshLocation() {

        latitude = (TextView) findViewById(R.id.latitude);
        longitude = (TextView) findViewById(R.id.longitude);
        provider = (TextView) findViewById(R.id.provider);

        criteria = new Criteria();
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        bestProvider = locationManager.getBestProvider(criteria, true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        location = locationManager.getLastKnownLocation(bestProvider);
        locationManager.requestLocationUpdates(bestProvider, 1000, 1, this);

        if (!(location==null))
        {
            provider.setText("Dostawca lokalizacji: " + bestProvider); //Wypełniamy pola tekstowe
            longitude.setText("Długość geograficzna: " + String.valueOf(location.getLongitude()));
            latitude.setText("Szerokość geograficzna: "+String.valueOf(location.getLatitude()));
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        refreshLocation();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        refreshLocation();
    }

    @Override
    public void onProviderDisabled(String provider1) {
        provider.setText("Brak danych o lokalizacji"); //Wypełniamy pola tekstowe
        longitude.setText("Brak danych o lokalizacji");
        latitude.setText("Brak danych o lokalizacji");
    }

    @Override
    protected void onResume(){
        super.onResume(); // Always call the superclass method first
        refreshLocation();
    }

    @Override
    protected void onPause(){
        super.onPause(); // Always call the superclass method first
        locationManager.removeUpdates(this); //Usuwamy aktualizację lokalizacji
    }

    public void onImageGalleryClicked(View v){
        Intent addPhotoIntent = new Intent(Intent.ACTION_PICK);

        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath = pictureDirectory.getPath();

        Uri data = Uri.parse(pictureDirectoryPath);

        addPhotoIntent.setDataAndType(data, "image/*");

        startActivityForResult(addPhotoIntent, IMAGE_GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            if (requestCode == IMAGE_GALLERY_REQUEST){
                Uri imageUri = data.getData();

                InputStream inputStream;

                try {
                    inputStream = getContentResolver().openInputStream(imageUri);

                    Bitmap image = BitmapFactory.decodeStream(inputStream);

                    //show image
                    imgReport.setImageBitmap(image);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Unable to open image", Toast.LENGTH_LONG).show();
                }
            }
            if (requestCode == CAMERA_REQUEST){
                //we are hearing back from camera
                Bitmap cameraImage = (Bitmap) data.getExtras().get("data");
                //we have the image from camera
                imgReport.setImageBitmap(cameraImage);
            }

        }


    }

    public void onTakePhotoClicked(View v) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    public void onSendReportClicked(View v){
        String textReportDescription = textDescription.getText().toString();


        Toast.makeText(this,nameOfEvent +" message send" ,Toast.LENGTH_LONG).show();

    }


}
