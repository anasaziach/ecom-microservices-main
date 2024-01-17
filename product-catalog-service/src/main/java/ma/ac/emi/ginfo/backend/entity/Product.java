package ma.ac.emi.ginfo.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table (name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "title")
    @NotNull
    private String title;

    @Column (name = "price")
    @NotNull
    private BigDecimal price;

    @Column (name = "description")
    private String description;

    @Column (name = "category")
    @NotNull
	@Enumerated(EnumType.STRING)
    private Category category;

	@Column (name = "disponibility")
	@NotNull
	private boolean disponibility;

    @Column (name = "availability")
    @NotNull
    private int availability;

	@Column (name = "img")
    @NotNull
    private String imgUrl;


	public Product() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isDisponibility() {
		return disponibility;
	}

	public void setDisponibility(boolean disponibility) {
		this.disponibility = disponibility;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Product(String title, BigDecimal price, String description, Category category, boolean disponibility, int availability, String imgUrl) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.category = category;
		this.disponibility = disponibility;
		this.availability = availability;
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", title='" + title + '\'' +
				", price=" + price +
				", description='" + description + '\'' +
				", category=" + category +
				", disponibility=" + disponibility +
				", availability=" + availability +
				", imgUrl='" + imgUrl + '\'' +
				'}';
	}
}
