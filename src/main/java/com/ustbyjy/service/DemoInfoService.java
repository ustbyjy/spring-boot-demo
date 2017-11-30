package com.ustbyjy.service;

import com.ustbyjy.domain.DemoInfo;

public interface DemoInfoService {

    DemoInfo findById(Long id);

    void deleteFromCache(Long id);

    void test();
}
