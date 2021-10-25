/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.model;

import javax.persistence.*;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private int sessionId;

    @Column(name = "user_id")
    private int userId;

    public Session(int sessionId, int userId) {
        this.sessionId = sessionId;
        this.userId = userId;
    }

    public Session() {

    }

    // Getters y setters
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
