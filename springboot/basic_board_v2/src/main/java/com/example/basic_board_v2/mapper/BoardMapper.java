package com.example.basic_board_v2.mapper;


import com.example.basic_board_v2.model.Article;
import com.example.basic_board_v2.model.Paging;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void saveArticle(Article article);
    List<Article> getArticles(Paging page);
    int getArticleCnt();
    Article getArticleById(long id);
    void updateArticle(Article article);
    void deleteBoardById(long id);
}