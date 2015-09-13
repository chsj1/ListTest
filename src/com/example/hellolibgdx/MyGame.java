package com.example.hellolibgdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MyGame implements ApplicationListener {
	// 定义一个Stage对象
	Stage stage;
	// 定义一个ListStyle对象
	ListStyle style;
	// 定义一个List对象
	List list;
	// 定义一个BitmapFont对象
	BitmapFont font;
	// 定义要显示出来的文字信息
	String itemStrs[];
	// 定义合图对象
	TextureAtlas spliteAtlas;
	// 定义选中时的背景的Region对象
	TextureRegion bgRegion;
	// 用于背景资源Atlas文件
	TextureAtlas bgAtlas;
	// 背景图片
	Image bbgImage;
	// 用作背景的资源的Region对象
	TextureRegion bbgRegion;

	@Override
	public void create() {
		// 初始化一个Stage对象
		stage = new Stage(480, 800, false);
		// 初始化合图对象
		spliteAtlas = new TextureAtlas(Gdx.files.internal("data/slider.atlas"));
		// 获取选中效果所对应的Region对象
		bgRegion = spliteAtlas.findRegion("bg");
		// 初始化List中所需要用到的BitmapFont对象
		font = new BitmapFont(Gdx.files.internal("data/font.fnt"), false);
		// 初始化列表的Style对象
		style = new ListStyle(font, Color.ORANGE, Color.PINK,
				new TextureRegionDrawable(bgRegion));
		// 构造出用于列表中的文字信息
		itemStrs = new String[6];
		int i;
		// 为每一个条目都构造出列表信息
		for (i = 0; i < 6; ++i) {
			// 为每一个条目构造一个列表信息
			itemStrs[i] = new String("hello libGDX " + i);
		}
		// 构造出List对象
		list = new List(itemStrs, style);
		// atlas对象的初始化
		bgAtlas = new TextureAtlas(Gdx.files.internal("data/movebg.atlas"));
		// 整个场景的背景的Region对象的初始化
		bbgRegion = bgAtlas.findRegion("movebg");
		// Image对象的初始化
		bbgImage = new Image(bbgRegion);
		// 设置图片的大小
		bbgImage.setSize(480, 800);
		// 将背景添加到舞台
		stage.addActor(bbgImage);
		// 将列表添加到舞台中Stage
		stage.addActor(list);
		// 使用Stage对象来处理输入输出事件
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);// 设置背景为白色
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// 清屏

		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}
