package com.gzj.express_transportation.entity;

public class Evaluate {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.e_id
     *
     * @mbg.generated
     */
    private Integer eId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.waybill_no
     *
     * @mbg.generated
     */
    private String waybillNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.kdy_id
     *
     * @mbg.generated
     */
    private Integer kdyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.kdy_name
     *
     * @mbg.generated
     */
    private String kdyName;


    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.kh_name
     *
     * @mbg.generated
     */
    private String khName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.branch
     *
     * @mbg.generated
     */
    private String branch;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.p_content
     *
     * @mbg.generated
     */
    private String pContent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.t_content
     *
     * @mbg.generated
     */
    private String tContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.e_id
     *
     * @return the value of evaluate.e_id
     *
     * @mbg.generated
     */
    public Integer geteId() {
        return eId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.e_id
     *
     * @param eId the value for evaluate.e_id
     *
     * @mbg.generated
     */
    public void seteId(Integer eId) {
        this.eId = eId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.waybill_no
     *
     * @return the value of evaluate.waybill_no
     *
     * @mbg.generated
     */
    public String getWaybillNo() {
        return waybillNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.waybill_no
     *
     * @param waybillNo the value for evaluate.waybill_no
     *
     * @mbg.generated
     */
    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo == null ? null : waybillNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.kdy_id
     *
     * @return the value of evaluate.kdy_id
     *
     * @mbg.generated
     */
    public Integer getKdyId() {
        return kdyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.kdy_id
     *
     * @param kdyId the value for evaluate.kdy_id
     *
     * @mbg.generated
     */
    public void setKdyId(Integer kdyId) {
        this.kdyId = kdyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.kdy_name
     *
     * @return the value of evaluate.kdy_name
     *
     * @mbg.generated
     */
    public String getKdyName() {
        return kdyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.kdy_name
     *
     * @param kdyName the value for evaluate.kdy_name
     *
     * @mbg.generated
     */
    public void setKdyName(String kdyName) {
        this.kdyName = kdyName == null ? null : kdyName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.kh_name
     *
     * @return the value of evaluate.kh_name
     *
     * @mbg.generated
     */
    public String getKhName() {
        return khName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.kh_name
     *
     * @param khName the value for evaluate.kh_name
     *
     * @mbg.generated
     */
    public void setKhName(String khName) {
        this.khName = khName == null ? null : khName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.branch
     *
     * @return the value of evaluate.branch
     *
     * @mbg.generated
     */
    public String getBranch() {
        return branch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.branch
     *
     * @param branch the value for evaluate.branch
     *
     * @mbg.generated
     */
    public void setBranch(String branch) {
        this.branch = branch == null ? null : branch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.p_content
     *
     * @return the value of evaluate.p_content
     *
     * @mbg.generated
     */
    public String getpContent() {
        return pContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.p_content
     *
     * @param pContent the value for evaluate.p_content
     *
     * @mbg.generated
     */
    public void setpContent(String pContent) {
        this.pContent = pContent == null ? null : pContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.t_content
     *
     * @return the value of evaluate.t_content
     *
     * @mbg.generated
     */
    public String gettContent() {
        return tContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.t_content
     *
     * @param tContent the value for evaluate.t_content
     *
     * @mbg.generated
     */
    public void settContent(String tContent) {
        this.tContent = tContent == null ? null : tContent.trim();
    }
}