package com.person.gen.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.session.RowBounds;

/**
 * 分页查询参数
 *
 * @author fu.yuanming
 * @since 2020-05-22
 */
@Data
public abstract class PageQueryParams {

  @ApiModelProperty("页数，默认 1")
  protected Integer pageNum;

  @ApiModelProperty("每页数量，默认 10")
  protected Integer pageSize;

  /**
   * 构造分页参数
   */
  public RowBounds buildRowBounds() {
    int num = pageNum == null ? 1 : pageNum;
    int size = pageSize == null ? 10 : pageSize;

    return new RowBounds((num - 1) * size, size);
  }

}
