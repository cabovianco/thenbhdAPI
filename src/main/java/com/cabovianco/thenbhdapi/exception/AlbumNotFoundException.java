package com.cabovianco.thenbhdapi.exception;

public class AlbumNotFoundException extends Exception {

    public AlbumNotFoundException(Long id) {
        super("Album with ID: " + id + " was not found.");
    }

}
