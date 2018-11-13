package pt.whatever.blowout;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class JsonParser {

    private static final String TAG_STUDENT_INFO = "studentsinfo";
    private static final String TAG_ID = "id";
    private static final String TAG_STUDENT_NAME = "sname";
    private static final String TAG_STUDENTEMAIL = "semail";
    private static final String TAG_ADDRESS = "address";
    private static final String TAG_STUDENT_GENDER = "gender";
    private static final String TAG_STUDENT_PHONE = "sphone";
    private static final String TAG_STUDENT_PHONE_MOBILE = "mobile";
    private static final String TAG_STUDENT_PHONE_HOME = "home";

    private ArrayList<HashMap<String, String>> ParseJSON(String json) {
        if (json != null) {
            try {
// Hashmap for ListView
                ArrayList<HashMap<String, String>> studentList = new ArrayList<HashMap<String, String>>();
                JSONObject jsonObj = new JSONObject(json);

// Getting JSON Array node
                JSONArray students = jsonObj.getJSONArray(TAG_STUDENT_INFO);

// looping through All Students
                for (int i = 0; i < students.length(); i++) {
                    JSONObject c = students.getJSONObject(i);

                    String id = c.getString(TAG_ID);
                    String sname = c.getString(TAG_STUDENT_NAME);

                    String address = c.getString(TAG_ADDRESS);
                    String gender = c.getString(TAG_STUDENT_GENDER);

// Phone node is JSON Object
                    JSONObject phone = c.getJSONObject(TAG_STUDENT_PHONE);
                    String mobile = phone.getString(TAG_STUDENT_PHONE_MOBILE);
                    String home = phone.getString(TAG_STUDENT_PHONE_HOME);

// tmp hashmap for single student
                    HashMap<String, String> student = new HashMap<String, String>();

// adding every child node to HashMap key => value
                    student.put(TAG_ID, id);
                    student.put(TAG_STUDENT_NAME, sname);

                    student.put(TAG_STUDENT_PHONE_MOBILE, mobile);

// adding student to students list
                    studentList.add(student);
                }
                return studentList;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            Log.e("ServiceHandler", "No data received from HTTP request");
            return null;
        }
    }
}
