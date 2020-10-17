package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Tags.TagEvent;

public interface TagService {
	public TagEvent addTag(TagEvent addTagEvent);
	public boolean deleteTag(TagEvent deleteTagEvent);
	public TagEvent updateTag(TagEvent updateTagEvent);
	public TagEvent getTags(TagEvent getTagEvent);
}
