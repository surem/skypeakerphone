package com.surem.cordova.skypeakerphone;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class skypeakerphone extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("turn_up")) {
            this.turn_up(callbackContext);
            return true;

        } else if (action.equals("turn_down")) {
            this.turn_down(callbackContext);
            return true;
        }
        return false;
    }

    private void turn_up(CallbackContext callbackContext) {
        AudioManager audioManager = (AudioManager) cordova.getActivity().getApplicationContext().getSystemService(Service.AUDIO_SERVICE);

        audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, 5, 0);
        audioManager.setSpeakerphoneOn(true);
        andorid.util.Log.d("skypeakerphone", "[skypeakerphone] turn_up()");

        callbackContext.success(message);
    }

    private void turn_down(CallbackContext callbackContext) {
        AudioManager audioManager = (AudioManager) cordova.getActivity().getApplicationContext().getSystemService(Service.AUDIO_SERVICE);

        audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, 1, 0);
        audioManager.setSpeakerphoneOn(false);
        andorid.util.Log.d("skypeakerphone", "[skypeakerphone] turn_down()");

        callbackContext.success(message);
    }
}
