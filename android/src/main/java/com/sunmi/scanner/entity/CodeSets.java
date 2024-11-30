package com.sunmi.scanner.entity;

import java.util.Objects;

public class CodeSets {
    public CodesRules codeRules;
    public CodeSetting codeSetting;
    public boolean enable;
    public boolean isSetting;
    public String name = "";

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.name, ((CodeSets) obj).name);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }

    public String toString() {
        return "CodeSets{name='" + this.name + '\'' + ", enable=" + this.enable + ", isSetting=" + this.isSetting + ", codeSetting=" + this.codeSetting + ", codeRules=" + this.codeRules + '}';
    }
}
