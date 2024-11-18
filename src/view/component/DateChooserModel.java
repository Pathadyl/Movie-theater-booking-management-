package view.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import view.customSwing.TestButtonAlignText;

public class DateChooserModel {
   
    private String day;
    private String dayOfWeek;
    private String dayOfMonth;
    private boolean isSelected = false;
    TestButtonAlignText button;
    private List<Timestamp> dateShowTimes;
    
   
    public DateChooserModel() {
        dateShowTimes = new ArrayList<>();
        button = new TestButtonAlignText();
        
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(String dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public TestButtonAlignText getButton() {
        return button;
    }

    public void setButton(TestButtonAlignText button) {
        this.button = button;
    }
    
    
    public List<Timestamp> getDateShowTimes() {
        return dateShowTimes;
    }

    public void setDateShowTimes(List<Timestamp> dateShowTimes) {
        this.dateShowTimes = dateShowTimes;
    }
    
    
    
    
}
