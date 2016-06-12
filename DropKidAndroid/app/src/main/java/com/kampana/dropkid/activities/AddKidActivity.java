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

import com.kampana.dropkid.R;


/**
 * Created by daniell on 10/06/16.
 */
public class AddKidActivity extends Activity implements TextWatcher {

    private static int RESULT_SELECT_KID_IMAGE = 1;


    private ImageView kidImage;
    private EditText kidName;
    private EditText dropOffTime;
    private EditText pickupTime;
    private Button saveButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();

        addListenersAndValidators();

    }

    private void addListenersAndValidators() {
        kidImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickKidImageIntent = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(pickKidImageIntent, RESULT_SELECT_KID_IMAGE);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // closing this activity
                finish();
            }
        });

        kidName.addTextChangedListener(this);
        dropOffTime.addTextChangedListener(this);
        pickupTime.addTextChangedListener(this);

    }

    private void bindViews() {
        setContentView(R.layout.add_kid_content);
        kidImage = (ImageView) findViewById(R.id.kidImage);
        kidName = (EditText) findViewById(R.id.kidName);
        dropOffTime = (EditText) findViewById(R.id.dropOffTime);
        pickupTime = (EditText) findViewById(R.id.pickupTime);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setEnabled(false);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == RESULT_SELECT_KID_IMAGE && resultCode == RESULT_OK && null != intent) {
             Uri selectedImage = intent.getData();
           String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();


            kidImage.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { /* not interesting */}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {/* not interesting */ }

    @Override
    public void afterTextChanged(Editable s) {
        boolean allFieldsValid = true;
        if(kidName.getText().toString().isEmpty()) {
            allFieldsValid = false;
            kidName.setError(getResources().getString(R.string.error_empty_name));
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
