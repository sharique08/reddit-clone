package com.example.springredditclone.model;

public enum VoteType {
    UPVOTE(direction: 1), DOWNVOTE(direction:-1),
        ;
    VoteType(int direction){
    }
}
