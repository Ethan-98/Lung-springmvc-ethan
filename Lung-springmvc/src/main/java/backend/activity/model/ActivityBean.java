package backend.activity.model;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Activity_Table")
public class ActivityBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer ac_id;//勿寫doble int型態，小寫型態不准用
	
	@Column(columnDefinition = "NVARCHAR(50) NOT NULL")
	String ac_name;
//	String ac_image;

	@Column(columnDefinition = "DATE NOT NULL")
	Date ac_date;

	@Column(columnDefinition = "NVARCHAR(20) NOT NULL")
	String ac_participant;
	
	@Column(columnDefinition = "NVARCHAR(50) NOT NULL")
	String ac_venue;

	@Column(columnDefinition = "NVARCHAR(20) NOT NULL")
	Integer ac_quota;

	@Column(columnDefinition = "NVARCHAR(20) NOT NULL")
	Integer ac_waitlist_quota;

	@Column(columnDefinition = "NVARCHAR(20) NOT NULL")
	Integer ac_fee;

	@Column(columnDefinition = "NVARCHAR(20) NOT NULL")
	String ac_organizer;
	

	String localfileName;
	
	Blob image;
	
	@Transient
	MultipartFile productImage;
	
	
	public ActivityBean() {
	}

	public ActivityBean(String ac_name, Date ac_date, String ac_participant, String ac_venue,
			Integer ac_quota, Integer ac_waitlist_quota, Integer ac_fee, String ac_organizer) {
		super();
		this.ac_name = ac_name;
//		this.ac_image = ac_image;
		this.ac_date = ac_date;
		this.ac_participant = ac_participant;
		this.ac_venue = ac_venue;
		this.ac_quota = ac_quota;
		this.ac_waitlist_quota = ac_waitlist_quota;
		this.ac_fee = ac_fee;
		this.ac_organizer = ac_organizer;
	}
	
	public ActivityBean(Integer ac_id, String ac_name, Date ac_date, String ac_participant,
			String ac_venue, Integer ac_quota, Integer ac_waitlist_quota, Integer ac_fee, String ac_organizer) {
		super();
		this.ac_id = ac_id;
		this.ac_name = ac_name;
//		this.ac_image = ac_image;
		this.ac_date = ac_date;
		this.ac_participant = ac_participant;
		this.ac_venue = ac_venue;
		this.ac_quota = ac_quota;
		this.ac_waitlist_quota = ac_waitlist_quota;
		this.ac_fee = ac_fee;
		this.ac_organizer = ac_organizer;
	}

	public ActivityBean(Integer ac_id) {
		this.ac_id = ac_id;
	}

	public ActivityBean(int ac_id2, String ac_name2, Date ac_date2, String ac_participant2, String ac_venue2,
			int ac_quota2, int ac_waitlist_quota2, int ac_fee2, String ac_organizer2) {
		// TODO Auto-generated constructor stub
	}

	public Integer getAc_id() {
		return ac_id;
	}
	public void setAc_id(Integer ac_id) {
		this.ac_id = ac_id;
	}
	public String getAc_name() {
		return ac_name;
	}
	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}
//	public String getAc_image() {
//		return ac_image;
//	}
//	public void setAc_image(String ac_image) {
//		this.ac_image = ac_image;
//	}
	public Date getAc_date() {
		return ac_date;
	}
	public void setAc_date(Date ac_date) {
		this.ac_date = ac_date;
	}
	public String getAc_participant() {
		return ac_participant;
	}
	public void setAc_participant(String ac_participant) {
		this.ac_participant = ac_participant;
	}
	public String getAc_venue() {
		return ac_venue;
	}
	public void setAc_venue(String ac_venue) {
		this.ac_venue = ac_venue;
	}
	public Integer getAc_quota() {
		return ac_quota;
	}
	public void setAc_quota(Integer ac_quota) {
		this.ac_quota = ac_quota;
	}
	public Integer getAc_waitlist_quota() {
		return ac_waitlist_quota;
	}
	public void setAc_waitlist_quota(Integer ac_waitlist_quota) {
		this.ac_waitlist_quota = ac_waitlist_quota;
	}
	public Integer getAc_fee() {
		return ac_fee;
	}
	public void setAc_fee(Integer ac_fee) {
		this.ac_fee = ac_fee;
	}
	public String getAc_organizer() {
		return ac_organizer;
	}
	public void setAc_organizer(String ac_organizer) {
		this.ac_organizer = ac_organizer;
	}

	public String getLocalfileName() {
		return localfileName;
	}

	public void setLocalfileName(String localfileName) {
		this.localfileName = localfileName;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	
	
}
