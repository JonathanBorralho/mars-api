package br.jus.trema.mars.api.config;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CacheEventLogger implements CacheEventListener<Object, Object> {

	@Override
	public void onEvent(CacheEvent<? extends Object, ? extends Object> event) {
		log.info("Cache Event: {} {} {}", event.getKey(), event.getOldValue(), event.getNewValue());
	}

}
