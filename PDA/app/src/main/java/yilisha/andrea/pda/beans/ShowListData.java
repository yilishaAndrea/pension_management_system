package yilisha.andrea.pda.beans;

/**
 * Created by yilisha andrea on 2018/6/17.
 */

public class ShowListData{
    private String PackageNumber;
    private String PickNumber;
    private boolean selected;
    private String isSend;

    public ShowListData(String packageNumber, String pickNumber, String isSend) {
        PackageNumber = packageNumber;
        PickNumber = pickNumber;
        this.isSend = isSend;
    }

    public String getPackageNumber() {
        return PackageNumber;
    }

    public void setPackageNumber(String packageNumber) {
        PackageNumber = packageNumber;
    }

    public String getPickNumber() {
        return PickNumber;
    }

    public void setPickNumber(String pickNumber) {
        PickNumber = pickNumber;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getIsSend() {
        return isSend;
    }

    public void setIsSend(String isSend) {
        this.isSend = isSend;
    }
}
