package com.cabovianco.thenbhdapi.exception;

public class SongNotFoundException extends Exception {

    public SongNotFoundException(Long id) {
        super("Song with ID: " + id + " was not found.");
    }

}
