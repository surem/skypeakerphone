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

    private void turn_up(String message, CallbackContext callbackContext) {
        AudioManager audioManager = (AudioManager) cordova.getActivity().getApplicationContext().getSystemService(Service.AUDIO_SERVICE);

        audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, 5, flags);
        audioManager.setSpeakerphoneOn(true);

        callbackContext.success(message);
    }

    private void turn_down(String message, CallbackContext callbackContext) {
        AudioManager audioManager = (AudioManager) cordova.getActivity().getApplicationContext().getSystemService(Service.AUDIO_SERVICE);

        audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, 1, flags);
        audioManager.setSpeakerphoneOn(false);

        callbackContext.success(message);
    }
}