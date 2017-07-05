package bbozo.sbz.webShop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConsumptionLimit implements Serializable {

	private static final long serialVersionUID = 9083859244284924082L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double pointsFrom;
	private double pointsTo;
	private double bonusPoints;

	
	@Override
	public String toString() {
		return "ConsumptionLimit [id=" + id + ", pointsFrom=" + pointsFrom + ", pointsTo=" + pointsTo + ", bonusPoints="
				+ bonusPoints + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPointsFrom() {
		return pointsFrom;
	}

	public void setPointsFrom(double pointsFrom) {
		this.pointsFrom = pointsFrom;
	}

	public double getPointsTo() {
		return pointsTo;
	}

	public void setPointsTo(double pointsTo) {
		this.pointsTo = pointsTo;
	}

	public double getBonusPoints() {
		return bonusPoints;
	}

	public void setBonusPoints(double bonusPoints) {
		this.bonusPoints = bonusPoints;
	}
	
}
