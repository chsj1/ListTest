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
	// ����һ��Stage����
	Stage stage;
	// ����һ��ListStyle����
	ListStyle style;
	// ����һ��List����
	List list;
	// ����һ��BitmapFont����
	BitmapFont font;
	// ����Ҫ��ʾ������������Ϣ
	String itemStrs[];
	// �����ͼ����
	TextureAtlas spliteAtlas;
	// ����ѡ��ʱ�ı�����Region����
	TextureRegion bgRegion;
	// ���ڱ�����ԴAtlas�ļ�
	TextureAtlas bgAtlas;
	// ����ͼƬ
	Image bbgImage;
	// ������������Դ��Region����
	TextureRegion bbgRegion;

	@Override
	public void create() {
		// ��ʼ��һ��Stage����
		stage = new Stage(480, 800, false);
		// ��ʼ����ͼ����
		spliteAtlas = new TextureAtlas(Gdx.files.internal("data/slider.atlas"));
		// ��ȡѡ��Ч������Ӧ��Region����
		bgRegion = spliteAtlas.findRegion("bg");
		// ��ʼ��List������Ҫ�õ���BitmapFont����
		font = new BitmapFont(Gdx.files.internal("data/font.fnt"), false);
		// ��ʼ���б��Style����
		style = new ListStyle(font, Color.ORANGE, Color.PINK,
				new TextureRegionDrawable(bgRegion));
		// ����������б��е�������Ϣ
		itemStrs = new String[6];
		int i;
		// Ϊÿһ����Ŀ��������б���Ϣ
		for (i = 0; i < 6; ++i) {
			// Ϊÿһ����Ŀ����һ���б���Ϣ
			itemStrs[i] = new String("hello libGDX " + i);
		}
		// �����List����
		list = new List(itemStrs, style);
		// atlas����ĳ�ʼ��
		bgAtlas = new TextureAtlas(Gdx.files.internal("data/movebg.atlas"));
		// ���������ı�����Region����ĳ�ʼ��
		bbgRegion = bgAtlas.findRegion("movebg");
		// Image����ĳ�ʼ��
		bbgImage = new Image(bbgRegion);
		// ����ͼƬ�Ĵ�С
		bbgImage.setSize(480, 800);
		// ��������ӵ���̨
		stage.addActor(bbgImage);
		// ���б���ӵ���̨��Stage
		stage.addActor(list);
		// ʹ��Stage������������������¼�
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
		Gdx.gl.glClearColor(1, 1, 1, 1);// ���ñ���Ϊ��ɫ
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);// ����

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
