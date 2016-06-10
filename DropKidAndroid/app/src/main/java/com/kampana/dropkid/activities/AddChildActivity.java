package com.kampana.dropkid.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.kampana.dropkid.R;

/**
 * Created by daniell on 10/06/16.
 */
public class AddChildActivity extends Activity implements TextWatcher {

    private static int RESULT_SELECT_CHILD_IMAGE = 1;


    private ImageView childImage;
    private EditText childName;
    private EditText dropOffTime;
    private EditText pickupTime;
    private Button saveButton;
    private Button cancelButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();

        addListenersAndValidators();



    }

    private void addListenersAndValidators() {
        childImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickChildImageIntent = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(pickChildImageIntent, RESULT_SELECT_CHILD_IMAGE);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO store the data
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // closing this activity
                finish();
            }
        });

        childName.addTextChangedListener(this);
        dropOffTime.addTextChangedListener(this);
        pickupTime.addTextChangedListener(this);

    }

    private void bindViews() {
        setContentView(R.layout.add_child_content);
        childImage = (ImageView) findViewById(R.id.childImage);
        childName = (EditText) findViewById(R.id.childName);
        dropOffTime = (EditText) findViewById(R.id.dropOffTime);
        pickupTime = (EditText) findViewById(R.id.pickupTime);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setEnabled(false);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_SELECT_CHILD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.childImage);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { /* not interesting */}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {/* not interesting */ }

    @Override
    public void afterTextChanged(Editable s) {
        boolean allFieldsValid = true;
        if(childName.getText().toString().isEmpty()) {
            allFieldsValid = false;
            childName.setError(getResources().getString(R.string.error_empty_name));
        }

        // TODO validate all fields

        if(!allFieldsValid) {
            saveButton.setError(getResources().getString(R.string.error_complete_details));
        } else {
            saveButton.setError(null);
        }
        saveButton.setEnabled(allFieldsValid);
    }
}
