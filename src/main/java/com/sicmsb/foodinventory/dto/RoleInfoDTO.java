package com.sicmsb.foodinventory.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class RoleInfoDTO {

	@ApiModelProperty(value = "The unique identifier of the given task", readOnly = true)
	private Long id;
	@ApiModelProperty(value = "Description of the task", required = true)
	@NotNull(message = "NotNull.taskDTO.description")
	@Size(min = 1, max = 64, message = "Size.taskDTO.description")
	private String description;
	@ApiModelProperty(value = "Indication if the task was completed or not")
	private boolean completed;
	private static final long serialVersionUID = 1L;

}
