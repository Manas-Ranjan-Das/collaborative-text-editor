package com.example.operational_transform.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class EditDTO {
    private List<ChangeDTO> changes;
    private String eol;
    private int versionId;
    private long id;

    @JsonProperty("isEolChange") // Force output as "isEolChange"
    private boolean isEolChange;

    @JsonProperty("isUndoing")
    private boolean isUndoing;

    @JsonProperty("isRedoing")
    private boolean isRedoing;

    @JsonProperty("isFlush")
    private boolean isFlush;

    // Getters and Setters
    public List<ChangeDTO> getChanges() {
        return changes;
    }

    public void setChanges(List<ChangeDTO> changes) {
        this.changes = changes;
    }

    public String getEol() {
        return eol;
    }

    public void setEol(String eol) {
        this.eol = eol;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }

    @JsonProperty("isEolChange") // Ensure only "isEolChange" is serialized
    public boolean isEolChange() {
        return isEolChange;
    }

    public void setEolChange(boolean eolChange) {
        isEolChange = eolChange;
    }

    @JsonProperty("isUndoing")
    public boolean isUndoing() {
        return isUndoing;
    }

    public void setUndoing(boolean undoing) {
        isUndoing = undoing;
    }

    @JsonProperty("isRedoing")
    public boolean isRedoing() {
        return isRedoing;
    }

    public void setRedoing(boolean redoing) {
        isRedoing = redoing;
    }

    @JsonProperty("isFlush")
    public boolean isFlush() {
        return isFlush;
    }

    public void setFlush(boolean flush) {
        isFlush = flush;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
