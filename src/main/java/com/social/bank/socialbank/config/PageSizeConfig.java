package com.social.bank.socialbank.config;

import com.social.bank.socialbank.exceptions.PaginationSizeLimitExceededException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PageSizeConfig {

    public static void validate(String nameClass, Integer SIZE_MAX_PAGE, Integer size) {
        if (size > SIZE_MAX_PAGE) {
            log.error("Pagination size limit exceeded = {}, maximum allowed = {}", size, SIZE_MAX_PAGE);

            throw new PaginationSizeLimitExceededException(nameClass + " : findAll");
        }
    }
}
