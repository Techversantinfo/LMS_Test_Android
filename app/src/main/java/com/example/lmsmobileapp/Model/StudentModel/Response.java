package com.example.lmsmobileapp.Model.StudentModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("user_is_active")
    @Expose
    private String userIsActive;
    @SerializedName("group_id")
    @Expose
    private String groupId;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("account_id")
    @Expose
    private String accountId;
    @SerializedName("account_id_for_removed")
    @Expose
    private Object accountIdForRemoved;
    @SerializedName("api_users_id")
    @Expose
    private String apiUsersId;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("national_id")
    @Expose
    private String nationalId;
    @SerializedName("national_id_end")
    @Expose
    private String nationalIdEnd;
    @SerializedName("employee_id")
    @Expose
    private String employeeId;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("first_name_ar")
    @Expose
    private String firstNameAr;
    @SerializedName("last_name_ar")
    @Expose
    private String lastNameAr;
    @SerializedName("date_of_birth")
    @Expose
    private Object dateOfBirth;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("center")
    @Expose
    private String center;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("extra")
    @Expose
    private String extra;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("cc_emails")
    @Expose
    private String ccEmails;
    @SerializedName("send_progress")
    @Expose
    private String sendProgress;
    @SerializedName("send_progress_last_date")
    @Expose
    private Object sendProgressLastDate;
    @SerializedName("report_frequency")
    @Expose
    private Object reportFrequency;
    @SerializedName("activate_date")
    @Expose
    private Object activateDate;
    @SerializedName("first_login")
    @Expose
    private String firstLogin;
    @SerializedName("is_test")
    @Expose
    private String isTest;
    @SerializedName("isTna")
    @Expose
    private String isTna;
    @SerializedName("isNotice")
    @Expose
    private String isNotice;
    @SerializedName("request_group_id")
    @Expose
    private Object requestGroupId;
    @SerializedName("Record_Creation_Date")
    @Expose
    private String recordCreationDate;
    @SerializedName("assigned")
    @Expose
    private Integer assigned;
    @SerializedName("progress")
    @Expose
    private Integer progress;
    @SerializedName("viewed")
    @Expose
    private Integer viewed;
    @SerializedName("passed")
    @Expose
    private Integer passed;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserIsActive() {
        return userIsActive;
    }

    public void setUserIsActive(String userIsActive) {
        this.userIsActive = userIsActive;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Object getAccountIdForRemoved() {
        return accountIdForRemoved;
    }

    public void setAccountIdForRemoved(Object accountIdForRemoved) {
        this.accountIdForRemoved = accountIdForRemoved;
    }

    public String getApiUsersId() {
        return apiUsersId;
    }

    public void setApiUsersId(String apiUsersId) {
        this.apiUsersId = apiUsersId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalIdEnd() {
        return nationalIdEnd;
    }

    public void setNationalIdEnd(String nationalIdEnd) {
        this.nationalIdEnd = nationalIdEnd;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstNameAr() {
        return firstNameAr;
    }

    public void setFirstNameAr(String firstNameAr) {
        this.firstNameAr = firstNameAr;
    }

    public String getLastNameAr() {
        return lastNameAr;
    }

    public void setLastNameAr(String lastNameAr) {
        this.lastNameAr = lastNameAr;
    }

    public Object getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Object dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCcEmails() {
        return ccEmails;
    }

    public void setCcEmails(String ccEmails) {
        this.ccEmails = ccEmails;
    }

    public String getSendProgress() {
        return sendProgress;
    }

    public void setSendProgress(String sendProgress) {
        this.sendProgress = sendProgress;
    }

    public Object getSendProgressLastDate() {
        return sendProgressLastDate;
    }

    public void setSendProgressLastDate(Object sendProgressLastDate) {
        this.sendProgressLastDate = sendProgressLastDate;
    }

    public Object getReportFrequency() {
        return reportFrequency;
    }

    public void setReportFrequency(Object reportFrequency) {
        this.reportFrequency = reportFrequency;
    }

    public Object getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Object activateDate) {
        this.activateDate = activateDate;
    }

    public String getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(String firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getIsTest() {
        return isTest;
    }

    public void setIsTest(String isTest) {
        this.isTest = isTest;
    }

    public String getIsTna() {
        return isTna;
    }

    public void setIsTna(String isTna) {
        this.isTna = isTna;
    }

    public String getIsNotice() {
        return isNotice;
    }

    public void setIsNotice(String isNotice) {
        this.isNotice = isNotice;
    }

    public Object getRequestGroupId() {
        return requestGroupId;
    }

    public void setRequestGroupId(Object requestGroupId) {
        this.requestGroupId = requestGroupId;
    }

    public String getRecordCreationDate() {
        return recordCreationDate;
    }

    public void setRecordCreationDate(String recordCreationDate) {
        this.recordCreationDate = recordCreationDate;
    }

    public Integer getAssigned() {
        return assigned;
    }

    public void setAssigned(Integer assigned) {
        this.assigned = assigned;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getViewed() {
        return viewed;
    }

    public void setViewed(Integer viewed) {
        this.viewed = viewed;
    }

    public Integer getPassed() {
        return passed;
    }

    public void setPassed(Integer passed) {
        this.passed = passed;
    }

}
